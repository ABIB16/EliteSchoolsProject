import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {Livre} from "./livre";
import {LivreService} from "./livreService";
import {MatPaginator} from "@angular/material/paginator";
import {Router} from "@angular/router";
import {log} from "util";

@Component({
  selector: 'app-livre',
  templateUrl: './list-livre.component.html',
  styleUrls: ['./list-livre.component.scss']
})
export class ListLivreComponent implements OnInit, AfterViewInit  {

  livres: Livre[]=[];
  public displayedColumns = ['nomLivre', 'typeLivre', 'prixLivre','Actions'];
  public dataSource = new MatTableDataSource<Livre>();
  @ViewChild(MatPaginator) private paginator: MatPaginator | undefined;

  ngAfterViewInit(): void {
    // @ts-ignore
    this.dataSource.paginator = this.paginator;
  }

  constructor(private livreService: LivreService,
              private router: Router) { }

  ngOnInit(): void {
    this.getLivreInformation();
  }

  getLivreInformation(){
    this.livreService.getAll()
      .subscribe((res)=>{
        console.log(res);
        this.dataSource.data = res;
      })
  }

  deleteEmployee(employeeId: number) {
    if (confirm("Voulez vous vraiement supprimer ?")) {
      this.livreService.deleteLivreById(employeeId).subscribe(() => {
        this.getLivreInformation();
      });
    }}




  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

   ggg()
  {
    this.router.navigateByUrl("administration/addlivre");
    console.log(this.router.url);
  }





}
