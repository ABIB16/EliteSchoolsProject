import { NgModule,CUSTOM_ELEMENTS_SCHEMA  } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';

import { CoreModule } from '@core/core.module';
import { ThemeModule } from '@theme/theme.module';
import { SharedModule } from '@shared/shared.module';
import { RoutesModule } from './routes/routes.module';
import { FormlyConfigModule } from './formly-config.module';
import { NgxPermissionsModule } from 'ngx-permissions';
import { ToastrModule } from 'ngx-toastr';
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';

import { environment } from '@env/environment';
import { BASE_URL, httpInterceptorProviders, appInitializerProviders } from '@core';

import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemDataService } from '@shared/in-mem/in-mem-data.service';
import {LivreService} from "./routes/systeme/ecolePrive/livre/livreService";
import {MatiereService} from "./routes/systeme/coursSoutien/service/MatiereService";
import {NiveauService} from "./routes/systeme/coursSoutien/service/NiveauService";
import {FormsModule} from "@angular/forms";
import {CycleService} from "./routes/systeme/coursSoutien/service/CycleService";
import {EleveService} from "./routes/gestionSoutien/gestionEleve/Service/EleveService";
import {TableModule} from "primeng/table";
import {WilayaService} from "./routes/systeme/commun/wilaya/WilayaService";
import {CommuneService} from "./routes/systeme/commun/wilaya/CommuneService";
import {EcoleService} from "./routes/systeme/coursSoutien/service/EcoleService";
import {GroupeService} from "./routes/systeme/coursSoutien/service/GroupeService";
import {EnseignantService} from "./routes/systeme/coursSoutien/service/EnseignantService";
import {PersonnelService} from "./routes/systeme/coursSoutien/service/PersonnelService";
import {ConfirmationService, MessageService} from "primeng/api";
import {MatPaginatorModule} from "@angular/material/paginator";
import {InscriptionMatiereService} from "./routes/gestionSoutien/gestionEleve/Service/InscriptionMatiereService";
import {PaiementService} from "./routes/gestionSoutien/gestionPaiement/Service/PaiementService";
import {PresenceService} from "./routes/gestionSoutien/gestionPaiement/Service/PresenceService";


// Required for AOT compilation
export function TranslateHttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}

@NgModule({
  declarations: [AppComponent],
  imports: [
    FormsModule,
    BrowserModule,
    MatPaginatorModule,
    BrowserAnimationsModule,
    HttpClientModule,
    CoreModule,
    TableModule,
    ThemeModule,
    RoutesModule,
    SharedModule,
    FormlyConfigModule.forRoot(),
    NgxPermissionsModule.forRoot(),
    ToastrModule.forRoot(),
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: TranslateHttpLoaderFactory,
        deps: [HttpClient],
      },
    }),
    // Demo purposes only for GitHub Pages
    HttpClientInMemoryWebApiModule.forRoot(InMemDataService, {
      dataEncapsulation: false,
      passThruUnknownUrl: true,
    }),
  ],
  providers: [
    { provide: BASE_URL, useValue: environment.baseUrl },
    httpInterceptorProviders,
    appInitializerProviders,
    LivreService,
    MatiereService,
    NiveauService,
    CycleService,
    WilayaService,
    EleveService,
    CommuneService,
    EcoleService,
    GroupeService,
    EnseignantService,
    PersonnelService,
    MessageService,
    InscriptionMatiereService,
    PaiementService,
    ConfirmationService,
    PresenceService
  ],
  bootstrap: [AppComponent],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ]
})
export class AppModule {}
