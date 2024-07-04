import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { abcForms } from '../../../../../../../environments/generals';
import { Instructor } from '../../../instructor/models/instructor';  // Ruta ajustada para el modelo Instructor
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatDialogRef } from '@angular/material/dialog';
import { InstructorService } from '../../../../../../providers/services/setup/instructor.service';  // Ruta ajustada para el servicio InstructorService

@Component({
    selector: 'app-clase-new',
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
    templateUrl: './clase-new.component.html',
})
export class ClaseNewComponent implements OnInit {
    @Input() title: string = '';
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
        private dialogRef: MatDialogRef<ClaseNewComponent>,
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
