import { Component, OnInit } from '@angular/core';
import {Livre} from "./livre";
import {LivreService} from "./livreService";
import {ActivatedRoute} from "@angular/router";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {MessageService} from "@shared";

@Component({
  selector: 'app-edit-livre',
  templateUrl: './add-edit-livre.component.html',
  styleUrls: ['./add-edit-livre.component.scss']
})
export class AddEditLivreComponent implements OnInit {
 // livre: Livre = new Livre();
  livre!: Livre;
  reactiveForm1!: FormGroup;
  currentLivreId! : number;
  editmode = false;


  constructor(private productService:LivreService,
              private route:ActivatedRoute,
              private fb: FormBuilder
  ) {}

  ngOnInit(): void {

    this.initForm();
    this.checkEditMode();
   // const param = this.route.snapshot.paramMap.get('id');
    /*if (param) {
      console.log('this is num appel offre :  ' + param);
      const id = +param;
      this.detailsAnnee(id);
    }*/
  }

  /*detailsAnnee(num: number): void{
    this.productService.getDetailAnnee(num).subscribe({
      next: data => this.livre = data,
    });
  }*/

  get productForm() {
    return this.reactiveForm1.controls;
  }

  private initForm() {
    this.reactiveForm1 = this.fb.group({
      idLivre: ['', Validators.required],
      nomLivre: ['', Validators.required],
      prixLivre: ['', Validators.required],
      typeLivre: ['prive']
    });
  }

  private checkEditMode() {
    this.route.params.subscribe((params) => {
      if (params.id) {
        this.editmode = true;
        this.currentLivreId = params.id;
        this.productService.getDetailLivre(params.id).subscribe((livre) => {
          this.productForm.idLivre.setValue(livre.idLivre);
          this.productForm.nomLivre.setValue(livre.nomLivre);
          this.productForm.prixLivre.setValue(livre.prixLivre);
        });
      }
    });
  }

  onSubmit() {
    if (this.editmode) {
    this.productService.updateLivre(this.reactiveForm1.value,this.currentLivreId).subscribe((res:any) => {
    })
    }
    else{
      const p = {...this.livre, ...this.reactiveForm1.value};
      console.log('this is p' + JSON.stringify(p));
      this.productService.createLivre(this.reactiveForm1.value).subscribe((res:any) => {
      })
    }
  }

  previousState(): void {
    window.history.back();
  }
}
