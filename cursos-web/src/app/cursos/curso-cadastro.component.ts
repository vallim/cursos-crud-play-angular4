import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

import { Curso } from "./curso";
import { CategoriaService } from "../shared/categoria.service";
import { PeriodoService } from "../shared/periodo.service";
import { CursoService } from "./curso.service";


@Component({
    templateUrl: "./curso-cadastro.component.html",
    styleUrls: ['./curso-cadastro.component.css']
})
export class CursoCadastroComponent implements OnInit {
    
    private curso: Curso;
    private categorias: string[];
    private periodos: string[];

    constructor(private router: Router, private cursoSerivce: CursoService, private categoriaService: CategoriaService, private periodoService: PeriodoService) {
        this.curso = new Curso();
        this.curso.categoria = null;
        this.curso.periodo = null;
    }

    ngOnInit(): void {
        this.categoriaService.findAll().subscribe(data => this.categorias = data);
        this.periodoService.findAll().subscribe(data => this.periodos = data);
    }

    salvar(curso: Curso) {
        this.cursoSerivce.save(curso)
        .subscribe(data => {
            this.router.navigate(['/cursos']);
        }, error => {
            console.error("Não foi possível criar um novo curso");
        });
    }
}