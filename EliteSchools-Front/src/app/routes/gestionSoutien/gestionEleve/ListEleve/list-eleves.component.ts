import {Component, OnInit, ViewChild} from '@angular/core';
import {EleveService} from "../Service/EleveService";
import {Router} from "@angular/router";
import { DomSanitizer } from '@angular/platform-browser';


@Component({
  selector: 'app-list-eleves',
  templateUrl: './list-eleves.component.html',
  styleUrls: ['./list-eleves.component.scss']
})
export class ListElevesComponent implements OnInit {
  public listeleve: any;
  loadingDots!: boolean;
  currentPage: number = 0;
  size: number = 6
  pages: any;
  totalRecords!: number;
  imageLocation = './assets/images/' ;

  constructor(private eleveService: EleveService,
              private router: Router,
              private sanitizer: DomSanitizer) {
  }

  transform(url: string) {
    return this.sanitizer.bypassSecurityTrustResourceUrl(url);
  }



  ngOnInit(): void {
    this.getAllEleve();

  }

  private getAllEleve() {
    this.eleveService.getAllEleve(this.currentPage, this.size)
      .subscribe((data) => {
        console.log(data);
        this.listeleve = data;
        // @ts-ignore
      //  this.pages = data.totalPages;
      })
  }

  gotoPage(i: number) {
    this.currentPage = i;
    this.getAllEleve();
  }

  first = 0;

  prev() {
    this.currentPage--;
    this.getAllEleve();
  }

  next() {
    this.currentPage++;
    this.getAllEleve();
  }

  reset() {
    this.currentPage = 0;
    this.getAllEleve();
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
    this.getAllEleve();
  }

}
