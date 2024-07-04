import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { abcForms } from '../../../../../../../environments/generals';
import { Clase } from '../../models/clase';
import { Instructor } from '../../../instructor/models/instructor';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatDialogRef } from '@angular/material/dialog';
import { InstructorService } from '../../../../../../providers/services/setup/instructor.service';

@Component({
    selector: 'app-clase-edit',
    standalone: true,
    imports: [
        FormsModule,
        MatIconModule,
        MatButtonModule,
        ReactiveFormsModule,
        MatSlideToggleModule,
        MatFormFieldModule,
        MatInputModule,
    ],
    templateUrl: './clase-edit.component.html',
})
export class ClaseEditComponent implements OnInit {
    @Input() title: string = '';
    @Input() clase: Clase;
    abcForms: any;
    instructors: Instructor[] = [];
    claseForm = new FormGroup({
        tipo: new FormControl('', [Validators.required]),
        hora: new FormControl('', [Validators.required]),
        costo: new FormControl(0, [Validators.required]),
        cuposDisponibles: new FormControl(0, [Validators.required]),
        instructor: new FormControl('', [Validators.required])
    });

    constructor(
        private formBuilder: FormBuilder,
        private dialogRef: MatDialogRef<ClaseEditComponent>,
        private instructorService: InstructorService
    ) {}

    ngOnInit() {
        this.abcForms = abcForms;
        this.instructorService.getAll$().subscribe(
            (response) => {
                this.instructors = response;
            },
            (error) => {
                console.error('Error fetching instructors:', error);
            }
        );

        if (this.clase) {
            this.claseForm.patchValue({
                tipo: this.clase.tipo,
                hora: this.clase.hora,
                costo: this.clase.costo,
                cuposDisponibles: this.clase.cuposDisponibles,
                instructor: this.clase.instructor.toString()  // Convertir a cadena
            });
        }
    }

    public saveForm(): void {
        if (this.claseForm.valid) {
            this.dialogRef.close(this.claseForm.value);
        }
    }

    public cancelForm(): void {
        this.dialogRef.close(null);
    }
}
