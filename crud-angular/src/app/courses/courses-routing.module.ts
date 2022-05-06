import { CourseFormComponent } from './course-form/course-form.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CursesComponent } from './courses/curses.component';

const routes: Routes = [
  {path:'', component: CursesComponent},
  {path:'new', component: CourseFormComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CoursesRoutingModule { }
