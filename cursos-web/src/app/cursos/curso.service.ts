import { Injectable } from "@angular/core";
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

import { Configuration } from "../shared/configuration";
import { Curso } from "./curso";

import { Observable } from "rxjs/Observable";

@Injectable()
export class CursoService {

    constructor(private httpClient: HttpClient, private configuration: Configuration) {}

    findAll(): Observable<Curso[]> {
        return this.httpClient.get<Curso[]>(this.configuration.getUrl('/cursos'), {})
    }

    save(curso: Curso): Observable<Curso> {
        return this.httpClient.post<Curso>(this.configuration.getUrl('/cursos'), curso);
    }

    delete(id: number) {
        return this.httpClient.delete(this.configuration.getUrl('/cursos/' + id))
    }
}