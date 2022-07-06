import { NgModule } from '@angular/core';
import { SharedModule } from '@shared/shared.module';
import {ListLivreComponent} from "./ecolePrive/livre/list-livre.component";
import { AddEditLivreComponent } from './ecolePrive/livre/add-edit-livre.component';
import {ListMatieresComponent} from "./coursSoutien/matieres/list-matieres.component";
import {AddMatiereComponent} from "./coursSoutien/matieres/addMatiere.component";
import {AdministrationRoutingModule} from "./administration-routing.module";
import { ListNiveauxComponent } from './coursSoutien/niveaux/list-niveaux.component';
//import {AddNiveauModalComponent} from "./coursSoutien/matieres/add-niveau-modal.component";
import {EditMatiereComponent} from "./coursSoutien/matieres/editMatiere.component";
import {TableModule} from "primeng/table";
import {ButtonModule} from "primeng/button";
import {InputTextModule} from "primeng/inputtext";
import {DropdownModule} from "primeng/dropdown";
import {CardModule} from "primeng/card";
import { ListWilayaComponent } from './commun/wilaya/list-wilaya.component';
import { ListCommunesComponent } from './commun/wilaya/list-communes.component';
import { ListEcoleComponent } from './coursSoutien/ecole/list-ecole.component';
import {RippleModule} from "primeng/ripple";

const COMPONENTS: any[] = [
  ListLivreComponent,
  AddEditLivreComponent,
  ListMatieresComponent,
  AddMatiereComponent,
  EditMatiereComponent];
const COMPONENTS_DYNAMIC: any[] = [];

@NgModule({
    imports: [SharedModule, AdministrationRoutingModule, TableModule, ButtonModule, InputTextModule, DropdownModule, CardModule, RippleModule],
  declarations: [...COMPONENTS, ...COMPONENTS_DYNAMIC, ListWilayaComponent, ListCommunesComponent, ListEcoleComponent],
})
export class AdministrationModule {}
