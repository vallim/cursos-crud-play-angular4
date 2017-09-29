import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/Observable";
import { Configuration } from "./configuration";

@Injectable()
export class PeriodoService {

    constructor(private httpClient: HttpClient, private configuration: Configuration) {}

    findAll(): Observable<string[]> {
        return this.httpClient.get<string[]>(this.configuration.getUrl('/periodos'));
    }
}