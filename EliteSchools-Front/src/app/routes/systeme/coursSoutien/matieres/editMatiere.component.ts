import {Component, OnInit, ViewChild} from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {LivreService} from "../../ecolePrive/livre/livreService";
import {ActivatedRoute} from "@angular/router";
import {Livre} from "../../ecolePrive/livre/livre";
import {Matiere} from "../entity/Matiere";
import {MatiereService} from "../service/MatiereService";
import {MatPaginator} from "@angular/material/paginator";
import {MatTable, MatTableDataSource} from "@angular/material/table";
import {NiveauService} from "../service/NiveauService";
import {NiveauScolaire} from "../entity/NiveauScolaire";
import {MatDialog, MatDialogRef} from "@angular/material/dialog";
import {AddNiveauModalComponent} from "./add-niveau-modal.component";
import {CycleScolaire} from "../entity/CycleScolaire";
import {CycleService} from "../service/CycleService";
import {TranslateService} from "@ngx-translate/core";
import { MtxGridColumn } from '@ng-matero/extensions/grid/grid.interface';
import {MtxDialog} from "@ng-matero/extensions/dialog";


@Component({
  selector: 'app-editMatiere',
  templateUrl: './editMatiere.component.html',

  styleUrls: ['./add-edit-matiere.component.scss']
})
export class EditMatiereComponent implements OnInit {
  matiere!: Matiere;
  matiereForm!: FormGroup;
  listNiveauForm!: FormGroup;
  currentMatiereId!: number;
  editmode = false;
  displayedColumns: string[] = [];
 // itemNiveau!: NiveauScolaire  ;
  cycles: CycleScolaire[]=[];

  @ViewChild(MatPaginator) private paginator: MatPaginator | undefined;
   dataSource = new MatTableDataSource<NiveauScolaire>();
   listNiveaux: NiveauScolaire[]=[];

  /*ngAfterViewInit(): void {
    // @ts-ignore
    this.dataSource.paginator = this.paginator;
  }*/

  constructor(private matiereService: MatiereService,
              private niveauService: NiveauService,
              private route: ActivatedRoute,
              private fb: FormBuilder,
            //  public dialog: MatDialog,
              private cycleService: CycleService) {
    this.displayedColumns = ['cycle','prix'];
  }


  ngOnInit(): void {
    this.initForm();
    this.checkEditMode();
    this.getAllCycle();
  }

  private initForm() {
    this.matiereForm = this.fb.group({
      idmatiere: ['', Validators.required],
      matiere: ['', Validators.required],
      niveauscolaireList: this.fb.array([]),
    });

    this.listNiveauForm= this.fb.group({
      intitule: ['', Validators.required],
      prix: ['', Validators.required],
      typeNiv: ['soutien']
    });
  }


  newNiveau(): void {
    if (this.listNiveauForm.valid) {
      const niv = this.fb.group({
        cycleniv: [this.listNiveauForm.value.intitule, Validators.required],
        prix: [this.listNiveauForm.value.prix, Validators.required],
        typeNiv: ['soutien']
      });


      this.dataSource.data.push({
        cycleniv: this.listNiveauForm.value.intitule,
        prix: this.listNiveauForm.value.prix,
        typeNiv: 'soutien'
      });

      this.dataSource.filter="";
      this.niveauscolaireList().push(niv);


      this.listNiveauForm.reset();
      console.log("rrrrrrrrrrrrrrrr "+this.dataSource.data.length)
      console.log("2222222222 "+  console.log(this.matiereForm.value));
    }
  }



  get formMatiere() {
    return this.matiereForm.controls;
  }

  niveauscolaireList(): FormArray {
    return this.matiereForm.get('niveauscolaireList') as FormArray;
  }

  removeNiveau(i:number) {
    this.niveauscolaireList().removeAt(i);
  }

  private checkEditMode() {
    this.route.params.subscribe((params) => {
      if (params.id) {
        this.editmode = true;
        this.currentMatiereId = params.id;

        this.niveauService.listNiveau( this.currentMatiereId)
          .subscribe((res)=>{
            console.log(res);
            this.dataSource.data = res;
          })

        console.log("1111111111111 " + this.currentMatiereId);
        this.matiereService.getDetailMatiere(params.id).subscribe((matiere) => {
          this.formMatiere.idmatiere.setValue(matiere.idmatiere)
          this.formMatiere.matiere.setValue(matiere.matiere);
//           this.matiereForm.setControl('niveauscolaireList' , this.listNiveau(matiere.niveauscolaireList));
        });
      }
    });
  }

  onSubmit() {
    if (this.editmode) {
      this.listNiveauForm.reset(this.listNiveauForm.value);
      this.matiereService.updateMatiere(this.matiereForm.value, this.currentMatiereId).subscribe((res: any) => {
        console.log('test update');
        const p = {... this.matiere, ...this.matiereForm.value}
        console.log('this is p update'+ JSON.stringify(p))
        console.log('zzzzzzzzzzzzzzzzzzzzzz '+this.dataSource);

      })

    } else {
      this.matiereService.createMatiere(this.matiereForm.value).subscribe((res:any) => {
        const p = {...this.matiere, ...this.matiereForm.value};
        console.log('this is neww' + JSON.stringify(p));
        console.log(this.matiereForm.value);
      })
    }
  }

  previousState(): void {
    window.history.back();
  }

  getAllNiveau() {
    this.niveauService.getAll()
      .subscribe((res) => {
        console.log(res);
        this.dataSource.data = res;
      })
  }

  /*private openAddNiveau() {
    return this.dialog.open(AddNiveauModalComponent, {
      width: '300px',
    });
  }

  addNiveau() {
    const dialogRef = this.openAddNiveau();
    this.handleAddFinish(dialogRef);
  }*/

  /* private getShoppingList() {
     this.niveauService.getShopping().subscribe((shoppings: NiveauScolaire[]) => {
       this.dataSource = new MatTableDataSource<NiveauScolaire>(shoppings);
     });
   }*/

  /*private handleAddFinish(dialogRef: MatDialogRef<AddNiveauModalComponent, any>) {
    dialogRef.afterClosed().subscribe((shoppingItemToAdd: NiveauScolaire) => {
      if (shoppingItemToAdd !== undefined) {
        console.log("2222222222222222 "+shoppingItemToAdd.cycleniv)
        this.niveauService.add(shoppingItemToAdd);

        console.log("rrrrrrrrrrrrrrrr "+this.dataSource.length)
        this.getShoppingList();
      }
    });
  }*/

  getAllCycle(){
    this.cycleService.getAll()
      .subscribe((res)=>{
        console.log(res);
        this.cycles = res;
      })
  }

  listNiveau(niveau: NiveauScolaire[]): FormArray{
    const listNiv = new FormArray([]);
    niveau.forEach(l => {
      listNiv.push(this.fb.group({
        idnivscolaire: l.idnivscolaire,
        //  cycleniv: l.cycleniv.code,
        prix: l.prix,
        typeNiv: 'soutien',
      }));
    });
    return  listNiv;
  }

  delete(value: any) {
   // this.dialog.alert(`You have deleted ${value.position}!`);
  }

}
