import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListLivreComponent} from "./ecolePrive/livre/list-livre.component";
import {AddEditLivreComponent} from "./ecolePrive/livre/add-edit-livre.component";
import {ListMatieresComponent} from "./coursSoutien/matieres/list-matieres.component";
import {AddMatiereComponent} from "./coursSoutien/matieres/addMatiere.component";
import {EditMatiereComponent} from "./coursSoutien/matieres/editMatiere.component";



const routes: Routes = [
  { path: 'matieres', component: ListMatieresComponent },
  { path: 'matieres/:id/edit', component: EditMatiereComponent },
  { path: 'matieres/add', component: AddMatiereComponent },
  { path: 'livres', component: ListLivreComponent },
  { path: 'addlivre', component: AddEditLivreComponent },
  { path: 'livres/:id/edit', component: AddEditLivreComponent },
  { path: 'livres/add', component: AddEditLivreComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AdministrationRoutingModule {}
