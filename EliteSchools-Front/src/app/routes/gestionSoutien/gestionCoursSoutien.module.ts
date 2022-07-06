import { NgModule } from '@angular/core';
import { SharedModule } from '@shared/shared.module';
import {GestionCoursSoutienRoutingModule} from "./gestionCoursSoutien-routing.module";
import {ListElevesComponent} from "./gestionEleve/ListEleve/list-eleves.component";
import { AddEleveComponent } from './gestionEleve/Add/add-eleve.component';
import {TableModule} from "primeng/table";
import {ButtonModule} from "primeng/button";
import {InputTextModule} from "primeng/inputtext";
import {CardModule} from "primeng/card";
import {DropdownModule} from "primeng/dropdown";
import {CalendarModule} from "primeng/calendar";
import {InputTextareaModule} from "primeng/inputtextarea";
import {TabViewModule} from "primeng/tabview";
import {FieldsetModule} from "primeng/fieldset";
import {FileUploadModule} from "primeng/fileupload";
import {InputMaskModule} from "primeng/inputmask";
import {DialogModule} from "primeng/dialog";
import {ToastModule} from "primeng/toast";
import {PaginatorModule} from "primeng/paginator";
import {EditEleveComponent} from "./gestionEleve/Edit/edit-eleve.component";
import {ListElevePreinscritComponent} from "./gestionEleve/ListElevePreinscrit/list-eleve-preinscrit.component";
import {ListAncienElevesComponent} from "./gestionEleve/ListAncienEleve/list-ancien-eleves.component";
import {EditEleveMajComponent} from "./gestionEleve/Edit/edit-eleve-maj.component";
import {ListPaiementComponent} from "./gestionPaiement/ListPaiement/list-paiement.component";
import {EditPaiementComponent} from "./gestionPaiement/edit/edit-paiement.component";
import {ConfirmDialogModule} from "primeng/confirmdialog";
import {ListPresenceComponent} from "./gestionEleve/ListPresence/list-presence.component";
import {CheckboxModule} from "primeng/checkbox";


const COMPONENTS: any[] = [
  ListElevesComponent,
  AddEleveComponent,
  EditEleveComponent,
  EditEleveMajComponent,
  ListElevePreinscritComponent,
  ListAncienElevesComponent,
  ListPresenceComponent,
  ListPaiementComponent,
  EditPaiementComponent
];
const COMPONENTS_DYNAMIC: any[] = [];

@NgModule({
  imports: [SharedModule, GestionCoursSoutienRoutingModule, TableModule, ButtonModule, InputTextModule, CardModule, DropdownModule, CalendarModule, InputTextareaModule, TabViewModule, FieldsetModule, FileUploadModule, InputMaskModule, DialogModule, ToastModule, PaginatorModule, ConfirmDialogModule, CheckboxModule],
  declarations: [...COMPONENTS, ...COMPONENTS_DYNAMIC],
})
export class GestionCoursSoutienModule { }
