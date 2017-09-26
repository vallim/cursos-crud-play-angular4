import { Injectable } from "@angular/core";
import { Curso } from "./curso";
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from "rxjs/Observable";

@Injectable()
export class CursoService {

    private endpoint = 'http://localhost:9000/api/cursos';

    constructor(private httpClient: HttpClient) {}

    findAll(): Observable<Curso[]> {
        return this.httpClient.get<Curso[]>(this.endpoint, {})
    }
}