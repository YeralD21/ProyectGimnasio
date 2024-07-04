import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ClaseService } from '../../../../../providers/services/setup/clase.service';
import { ConfirmDialogService } from '../../../../../shared/confirm-dialog/confirm-dialog.service';
import { ClaseNewComponent } from '../components/form/clase-new.component';
import { ClaseEditComponent } from '../components/form/clase-edit.component';
import { ClaseListComponent } from '../components/lists/clase-list.component';
import { Clase } from '../models/clase';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
    selector: 'app-clase-container',
    standalone: true,
    imports: [
        CommonModule,
        RouterOutlet,
        ClaseListComponent,
        ClaseNewComponent,
        ClaseEditComponent,
        FormsModule,
        ReactiveFormsModule,
    ],
    template: `
        <app-clase-list
            class="w-full"
            [clases]="clases"
            (eventNew)="eventNew()"
            (eventEdit)="eventEdit($event)"
            (eventDelete)="eventDelete($event)"
        ></app-clase-list>
    `,
})
export class ClaseContainerComponent implements OnInit {
    public error: string = '';
    public clases: Clase[] = [];
    public clase: Clase = {} as Clase;

    constructor(
        private claseService: ClaseService,
        private confirmDialogService: ConfirmDialogService,
        private matDialog: MatDialog
    ) {}

    ngOnInit() {
        this.getClases();
    }

    getClases(): void {
        this.claseService.getAll$().subscribe(
            (response) => {
                this.clases = response;
            },
            (error) => {
                this.error = error;
            }
        );
    }

    public eventNew(): void {
        const claseForm = this.matDialog.open(ClaseNewComponent);
        claseForm.componentInstance.title = 'Nueva Clase';
        claseForm.afterClosed().subscribe((result: any) => {
            if (result) {
                this.saveClase(result);
            }
        });
    }

    saveClase(data: Clase): void {
        this.claseService.add$(data).subscribe((response) => {
            if (response) {
                this.getClases();
            }
        });
    }

    public eventEdit(idClase: number): void {
        this.claseService.getById$(idClase).subscribe((response) => {
            this.clase = response || ({} as Clase);
            const claseForm = this.matDialog.open(ClaseEditComponent);
            claseForm.componentInstance.title = `Editar ${this.clase.tipo}`;
            claseForm.componentInstance.clase = this.clase;
            claseForm.afterClosed().subscribe((result: any) => {
                if (result) {
                    this.editClase(this.clase.id, result);
                }
            });
        });
    }

    editClase(idClase: number, data: Clase): void {
        this.claseService.update$(idClase, data).subscribe((response) => {
            if (response) {
                this.getClases();
            }
        });
    }

    public eventDelete(idClase: number) {
        this.confirmDialogService
            .confirmDelete({
                // title: 'Confirmación Personalizada',
                // message: ¿Quieres proceder con esta acción ${}?,
            })
            .then(() => {
                this.claseService.delete$(idClase).subscribe((response) => {
                    this.clases = response;
                });
                this.getClases();
            })
            .catch(() => {});
    }
}
