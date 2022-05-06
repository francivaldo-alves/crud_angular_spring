import { ErrorDialogComponent } from './../../shared/components/error-dialog/error-dialog.component';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { catchError, Observable, of } from 'rxjs';

import { Course } from '../model/course';
import { CoursesService } from '../services/courses.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-curses',
  templateUrl: './curses.component.html',
  styleUrls: ['./curses.component.scss']
})
export class CursesComponent implements OnInit {

  courses$: Observable<Course[]>;
  displayedColumns = ['_id', 'name', 'category','actions']

  //coursesServices:CoursesService;

  constructor(
    private coursesServices: CoursesService,
    public dialog: MatDialog,
    private router: Router,
    private route :ActivatedRoute

    ) {

    this.courses$ = this.coursesServices.list()
    .pipe(
      catchError(error =>{
        this.onError('Erro ao carregar cursos.')
        return of([])
      })
    );
  }
  onError(errorMsg:string) {
    this.dialog.open(ErrorDialogComponent,{
      data: errorMsg
    })
  }


  ngOnInit(): void {}

//rota formulario atraves do botao
  onAdd(){
    this.router.navigate(['new'], {relativeTo:this.route});

  }

}
