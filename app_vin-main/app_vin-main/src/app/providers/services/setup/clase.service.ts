import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { END_POINTS, EntityDataService, IResponse } from '../../utils';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class ClaseService extends EntityDataService<any> {
    constructor(protected override httpClient: HttpClient) {
        super(httpClient, END_POINTS.setup.clase);
    }

    createClase(clase: any): Observable<IResponse> {
        return this.httpClient.post<IResponse>(END_POINTS.setup.clase, clase);
    }

    // Otros métodos para manejar las clases
}
