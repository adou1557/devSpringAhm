import { Component, Inject } from '@angular/core';
import {
  MatDialogRef,
  MAT_DIALOG_DATA,
  MatDialogContent,
  MatDialogTitle,
  MatDialogActions
} from '@angular/material/dialog';
import {
  AbstractControl,
  FormBuilder,
  FormGroup, FormsModule, ReactiveFormsModule,
  ValidationErrors,
  ValidatorFn,
  Validators,
} from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { CommonModule } from '@angular/common';

export interface AppointmentData {
  uuid?: string;
  title: string;
  date: Date;
  startTime: string;
  endTime: string;
}
@Component({
  selector: 'app-appointment-dialog',
  templateUrl: './appointment-dialog.component.html',
  styleUrls: ['./appointment-dialog.component.scss'],
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatDatepickerModule,
    ReactiveFormsModule,
    MatDialogContent,
    MatDialogTitle,
    MatDialogActions,
  ],
})



export class AppointmentDialogComponent {
  appointmentForm: FormGroup;

  constructor(
    public dialogRef: MatDialogRef<AppointmentDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: AppointmentData,
    private formBuilder: FormBuilder
  ) {
    // Initialisation du formulaire avec des valeurs par défaut
    this.appointmentForm = this.formBuilder.group({
      title: [this.data.title || '', Validators.required],
      date: [this.data.date || '', Validators.required],
      startTime: [this.data.startTime || '12:00', Validators.required],
      endTime: [this.data.endTime || '13:00', Validators.required],
    }, { validators: this.timeRangeValidator });
  }

  // Annuler et fermer le dialog
  onNoClick(): void {
    this.dialogRef.close();
  }

  // Sauvegarder et retourner les données du formulaire
  onSaveClick(): void {
    if (this.appointmentForm.valid) {
      const updatedData = {
        ...this.appointmentForm.value,
        uuid: this.data.uuid,
      };
      this.dialogRef.close(updatedData);
    }
  }

  // Supprimer l'appoinement
  onDeleteClick(): void {
    this.dialogRef.close({ remove: true, uuid: this.data.uuid });
  }

  // Validateur pour vérifier que l'heure de fin est après l'heure de début
  timeRangeValidator: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {
    const group = control as FormGroup;
    const startTime = group.get('startTime')?.value;
    const endTime = group.get('endTime')?.value;

    if (startTime && endTime && startTime >= endTime) {
      return { timeRangeInvalid: true };
    }

    return null;
  };
}
