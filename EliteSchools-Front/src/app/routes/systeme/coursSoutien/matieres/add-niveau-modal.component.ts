import { Component, OnInit , NgModule } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import {NiveauScolaire} from "../entity/NiveauScolaire";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CycleScolaire} from "../entity/CycleScolaire";
import {CycleService} from "../service/CycleService";
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'cf-shopping-add-modal',
  templateUrl: './add-niveau-modal.component.html',
  styleUrls: ['./add-niveau-modal.component.scss']
})
export class AddNiveauModalComponent implements OnInit {

  shoppingItemToAdd = new NiveauScolaire  () ;

  formGrp!: FormGroup;
  /*foods: NiveauScolaire[] = [
    {cycle : 'steak-0',  prix: 10},
    {cycle: 'pizza-1', prix: 20},
    {cycle: 'tacos-2', prix: 30},
  ];*/

  cycles: CycleScolaire[]=[];
  public dataSource = new MatTableDataSource<CycleScolaire>();

  constructor(public dialogRef: MatDialogRef<AddNiveauModalComponent>,
              private fb: FormBuilder,
              private cycleService: CycleService) {

  }

  ngOnInit() {
  this.getAllCycle();
  this.initForm();
  }

  closeDialog() {
    this.dialogRef.close();
  }

  addShoppingItem() {
    this.dialogRef.close(this.shoppingItemToAdd);
  }

  private initForm() {
    this.formGrp = this.fb.group({
      cycleniv: ['', Validators.required],
      prix: [, Validators.required],
    });
  }

  get getNiveauForm() {
    return this.formGrp.controls;
  }


  getAllCycle(){
    this.cycleService.getAll()
      .subscribe((res)=>{
        console.log(res);
        this.cycles = res;
      })
  }
}
