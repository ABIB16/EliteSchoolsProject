import {Component, OnInit, ViewChild} from '@angular/core';
import {EleveService} from "../Service/EleveService";
import {Router} from "@angular/router";


@Component({
  selector: 'app-list-eleves',
  templateUrl: './list-ancien-eleves.component.html',
  styleUrls: ['./list-ancien-eleves.component.scss']
})
export class ListAncienElevesComponent implements OnInit {
  public listeleve: any;
  loadingDots!: boolean;
  currentPage: number = 0;
  size: number = 5
  pages: any;
  totalRecords!: number;

  constructor(private eleveService: EleveService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getAllAncienEleve();

  }

  private getAllAncienEleve() {
    this.eleveService.getAllAncienEleve(this.currentPage, this.size)
      .subscribe((data: { totalPages: any; }) => {
        console.log("------------------"+data);
        this.listeleve = data;
        this.pages = data.totalPages;
      })
  }

  gotoPage(i: number) {
    this.currentPage = i;
    this.getAllAncienEleve();
  }

  first = 0;

  prev() {
    this.currentPage--;
    this.getAllAncienEleve();
  }

  next() {
    this.currentPage++;
    this.getAllAncienEleve();
  }

  reset() {
    this.currentPage = 0;
    this.getAllAncienEleve();
  }

  // @ts-ignore
  isLastPage(): boolean {
    // return this.customers ? this.first === (this.customers.length - this.rows): true;
  }

  // @ts-ignore
  isFirstPage(): boolean {
    // return this.customers ? this.first === 0 : true;
  }

  onChange(event: any) {
    this.size = event.value;
    this.getAllAncienEleve();
  }

}
