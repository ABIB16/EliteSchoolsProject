import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {Router} from "@angular/router";
import {MatiereService} from "../service/MatiereService";
import {Matiere} from "../entity/Matiere";

@Component({
  selector: 'app-matieres',
  templateUrl: './list-matieres.component.html',
  styleUrls: ['./list-matieres.component.scss']
})
export class ListMatieresComponent implements OnInit {


 // listMatiere: Matiere[]=[];
  public displayedColumns = ['Matière','Actions'];
  public dataSource = new MatTableDataSource<Matiere>();
  @ViewChild(MatPaginator) private paginator: MatPaginator | undefined;

  ngAfterViewInit(): void {
    // @ts-ignore
    this.dataSource.paginator = this.paginator;
  }

  constructor(private matiereService: MatiereService,
              private router: Router) { }

  ngOnInit(): void {
    this.getAllMatiere();
  }

  getAllMatiere(){
    this.matiereService.getAll()
      .subscribe((res)=>{
        console.log(res);
        this.dataSource.data = res;
      })
  }

  deleteMatiere(idMatiere: number) {
    if (confirm("Voulez vous vraiement supprimer ?")) {
      this.matiereService.deleteMatiereById(idMatiere).subscribe(() => {
        this.getAllMatiere();
      });
    }}


  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  updateProduct(productid: string) {
    this.router.navigateByUrl(`administration/matieres/${productid}/edit`);
  }



}
