import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListElevesComponent} from "./gestionEleve/ListEleve/list-eleves.component";
import {AddEleveComponent} from "./gestionEleve/Add/add-eleve.component";
import {EditEleveComponent} from "./gestionEleve/Edit/edit-eleve.component";
import {ListElevePreinscritComponent} from "./gestionEleve/ListElevePreinscrit/list-eleve-preinscrit.component";
import {ListAncienElevesComponent} from "./gestionEleve/ListAncienEleve/list-ancien-eleves.component";
import {EditEleveMajComponent} from "./gestionEleve/Edit/edit-eleve-maj.component";
import {ListPaiementComponent} from "./gestionPaiement/ListPaiement/list-paiement.component";
import {EditPaiementComponent} from "./gestionPaiement/edit/edit-paiement.component";
import {ListPresenceComponent} from "./gestionEleve/ListPresence/list-presence.component";
import {ImpayesComponent} from "./gestionPaiement/Impayes/impayes.component";


const routes: Routes = [
 // { path: 'matieres', component: ListMatieresComponent },
 // { path: 'matieres/:id/edit', component: AddMatiereComponent },
  { path: 'listEleves', component: ListElevesComponent, },
  { path: 'ajouter-eleve', component: AddEleveComponent },
 // { path: 'modifier-eleve', component: EditPaiementComponent },
  { path: 'listEleves/ajouter-eleve', component: AddEleveComponent },
  { path: 'listEleves/modifier-eleve/:id', component: EditEleveComponent },
  { path: 'mise-a-jour-des-eleves/modifier-eleve-maj/:id', component: EditEleveMajComponent },
  { path: 'liste-eleves-preinscrits', component: ListElevePreinscritComponent, },
  { path: 'mise-a-jour-des-eleves', component: ListAncienElevesComponent, },
  { path: 'listPaiement', component: ListPaiementComponent, },
  { path: 'impaye', component: ImpayesComponent, },
  { path: 'listPaiement/modifier-paiement', component: EditPaiementComponent, },
  //{ path: 'livres/:id/edit', component: AddEditLivreComponent },
  //{ path: 'livres/add', component: AddEditLivreComponent }
  { path: 'liste-de-presence', component: ListPresenceComponent, }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class GestionCoursSoutienRoutingModule {}
