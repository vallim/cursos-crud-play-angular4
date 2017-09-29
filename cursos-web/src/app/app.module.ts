import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { CursoListagemComponent } from './cursos/curso-listagem.component';
import { CursoCadastroComponent } from "./cursos/curso-cadastro.component";

import { Configuration } from "./shared/configuration";
import { CursoService } from "./cursos/curso.service";
import { CategoriaService } from "./shared/categoria.service";
import { PeriodoService } from "./shared/periodo.service";

@NgModule({
  declarations: [
    AppComponent,
    CursoListagemComponent,
    CursoCadastroComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: 'cursos', component: CursoListagemComponent },
      { path: 'cursos/novo', component: CursoCadastroComponent },
    ])
  ],
  providers: [Configuration, CategoriaService, CursoService, PeriodoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
