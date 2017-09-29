import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Configuration } from "./configuration";
import { Observable } from "rxjs/Observable";

@Injectable()
export class CategoriaService {

    constructor(private httpClient: HttpClient, private configuration: Configuration) {}

    findAll(): Observable<string[]> {
        return this.httpClient.get<string[]>(this.configuration.getUrl('/categorias'));
    }
}