import { Component, OnInit } from '@angular/core';
import { Curso } from "./curso";
import { CursoService } from "./curso.service";

@Component({
  templateUrl: './curso-listagem.component.html'
})
export class CursoListagemComponent implements OnInit {

  private cursos: Curso[] = [];

  constructor(private cursoService: CursoService) { }

  ngOnInit() {
    this.carregarCursos();
  }

  private carregarCursos() {
    this.cursoService.findAll().subscribe(data => {
      this.cursos = data
    });
  }

  remover(curso: Curso) {
    if (confirm("Deseja mesmo excluir o curso: " + curso.nome + "?")) {
      this.cursoService.delete(curso.id).subscribe(
        data => {
            this.carregarCursos();
        },
        error => {
            console.error("Erro ao deletar o curso");
        }
      );
    }
  }
}