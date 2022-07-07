import {Component, OnInit, ViewChild} from '@angular/core';
import {Router} from "@angular/router";
import {PaiementService} from "../Service/PaiementService";
import {Message, MessageService} from "primeng/api";
import {Paiement} from "../Entity/Paiement";


@Component({
  selector: 'app-list-eleves',
  templateUrl: './list-paiement.component.html',
  styleUrls: ['./list-paiement.component.scss']
})
export class ListPaiementComponent implements OnInit {
  public listPaiement: any;
  paiement!: Paiement
  loadingDots!: boolean;
  currentPage: number = 0;
  size: number = 5
  pages: any;
  totalRecords!: number;

  constructor(private paiementService: PaiementService,
              private messageService: MessageService,
              private router: Router) {
  }

  updateProduct(productid: string) {
    this.router.navigateByUrl(`listPaiement/modifier-paiement/${productid}`);
  }

  ngOnInit(): void {
    this.getAllPaiement();

  }

  private getAllPaiement() {
    this.paiementService.getAllPaiement(this.currentPage, this.size)
      .subscribe((data) => {
        console.log(data);
        this.listPaiement = data;
      })
  }

  /*private getPaiementAntecedant() {
    this.paiementService.getAllPaiementAntecedent(2)
      .subscribe((data) => {
        console.log("antecedennnnnnnnnnnnnt "+data);
        this.listPaiement = data;

      })
  }*/

  gotoPage(i: number) {
    this.currentPage = i;
    this.getAllPaiement();
  }

  first = 0;

  prev() {
    this.currentPage--;
    this.getAllPaiement();
  }

  next() {
    this.currentPage++;
    this.getAllPaiement();
  }

  reset() {
    this.currentPage = 0;
    this.getAllPaiement();
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
    this.getAllPaiement();
  }

  onSubmit() {
    this.paiementService.genererAllPaiement(this.currentPage, this.size)
      .subscribe((data) => {
        console.log(data);
        this.listPaiement = data;
      });
    this.messageService.add({
      severity: 'success',
      summary: 'Information',
      detail: 'Les paiements ont été générés pour ce mois avec succès',
      life: 3000
    });
  }

}
