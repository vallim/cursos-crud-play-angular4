import { Component, OnInit } from '@angular/core';
import { Curso } from "./curso";
import { CursoService } from "./curso.service";

@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css']
})
export class CursosComponent implements OnInit {

  private cursos: Curso[] = [];

  constructor(private cursoService: CursoService) { }

  ngOnInit() {
    this.cursoService.findAll().subscribe(cursos => this.cursos = cursos);
  }
}
