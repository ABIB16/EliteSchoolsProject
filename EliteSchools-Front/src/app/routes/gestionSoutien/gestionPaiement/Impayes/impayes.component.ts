import {Component, OnInit, ViewChild} from '@angular/core';
import {Router} from "@angular/router";
import {PaiementService} from "../Service/PaiementService";
import {Message, MessageService} from "primeng/api";
import {Paiement} from "../Entity/Paiement";


@Component({
  selector: 'app-list-eleves',
  templateUrl: './impayes.component.html',
  styleUrls: ['./impays.component.scss']
})
export class ImpayesComponent implements OnInit {
  public listImpaye: any;

  constructor(private paiementService: PaiementService,
              private messageService: MessageService,
              private router: Router) {
  }

  updateProduct(productid: string) {
    this.router.navigateByUrl(`listPaiement/modifier-paiement/${productid}`);
  }

  ngOnInit(): void {
    this.getPaiementAntecedant();

  }

  private getPaiementAntecedant() {
    this.paiementService.getListImpaye("Juillet")
      .subscribe((data) => {
        console.log("antecedennnnnnnnnnnnnt "+data);
        this.listImpaye = data;

      })
  }


}
