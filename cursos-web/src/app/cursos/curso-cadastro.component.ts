import { Component, OnInit } from "@angular/core";
import { Curso } from "./curso";
import { CategoriaService } from "../shared/categoria.service";
import { PeriodoService } from "../shared/periodo.service";

@Component({
    templateUrl: "./curso-cadastro.component.html",
    styleUrls: ['./cursos.component.css']
})
export class CursoCadastroComponent implements OnInit {
    
    private curso: Curso = new Curso();

    private categorias: string[];

    private periodos = []

    constructor(private categoriaService: CategoriaService, private periodoService: PeriodoService) {}

    ngOnInit(): void {
        this.categoriaService.findAll().subscribe(data => this.categorias = data);
        this.periodoService.findAll().subscribe(data => this.periodos = data);
    }

    salvar() {
        console.log(this.curso);
    }
}