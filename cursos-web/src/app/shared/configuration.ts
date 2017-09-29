import { Injectable } from "@angular/core";

@Injectable()
export class Configuration {

    getUrl(uri: string): string {
        return 'http://localhost:9000/api' + uri;
    }
}