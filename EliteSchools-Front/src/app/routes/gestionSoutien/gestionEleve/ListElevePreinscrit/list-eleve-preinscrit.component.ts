import {Component, OnInit, ViewChild} from '@angular/core';
import {EleveService} from "../Service/EleveService";
import {Router} from "@angular/router";


@Component({
  selector: 'app-list-eleves',
  templateUrl: './list-eleves-preinscrit.component.html',
  styleUrls: ['./list-eleve-preinscrit.component.scss']
})
export class ListElevePreinscritComponent implements OnInit {
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
    this.getAllelevePreinscrit();

  }

  private getAllelevePreinscrit() {
    this.eleveService.getAllElevePreinscrit(this.currentPage, this.size)
      .subscribe((data: { totalPages: any; }) => {
        console.log(data);
        this.listeleve = data;
        this.pages = data.totalPages;
      })
  }

  gotoPage(i: number) {
    this.currentPage = i;
    this.getAllelevePreinscrit();
  }

  first = 0;

  prev() {
    this.currentPage--;
    this.getAllelevePreinscrit();
  }

  next() {
    this.currentPage++;
    this.getAllelevePreinscrit();
  }

  reset() {
    this.currentPage = 0;
    this.getAllelevePreinscrit();
  }

  onChange(event: any) {
    this.size = event.value;
    this.getAllelevePreinscrit();
  }

  // @ts-ignore
  isLastPage(): boolean {
    // return this.customers ? this.first === (this.customers.length - this.rows): true;
  }

  // @ts-ignore
  isFirstPage(): boolean {
    // return this.customers ? this.first === 0 : true;
  }

}
