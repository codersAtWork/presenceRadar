/*
 * Copyright (c) 2016 VMware, Inc. All Rights Reserved.
 * This software is released under MIT license.
 * The full license information can be found in LICENSE in the root directory of this project.
 */
import { ModuleWithProviders } from '@angular/core/src/metadata/ng_module';
import { Routes, RouterModule } from '@angular/router';

import { AboutComponent } from './about/about.component';
import { PersonOverviewComponent } from './person-overview/person-overview.component';
import { PersonEditComponent } from './person-edit/person-edit.component';
import { SettingsComponent } from './settings/settings.component';
import { TokenOverviewComponent } from './token-overview/token-overview.component';
import { LogsComponent } from './logs/logs.component';
import { TokenEditComponent } from './token-edit/token-edit.component';


export const ROUTES: Routes = [
    {path: '', redirectTo: 'persons', pathMatch: 'full'},
    {path: 'persons', component: PersonOverviewComponent},
    {path: 'person-add', component: PersonEditComponent},
    {path: 'person-edit/:id', component: PersonEditComponent},
    {path: 'tokens', component: TokenOverviewComponent},
    {path: 'token-add', component: TokenEditComponent},
    {path: 'token-edit/:id', component: TokenEditComponent},
    {path: 'settings', component: SettingsComponent},
    {path: 'logs', component: LogsComponent},
    {path: 'about', component: AboutComponent}
];

export const ROUTING: ModuleWithProviders = RouterModule.forRoot(ROUTES);
