import { NgModule } from '@angular/core';
import { SharedModule } from '@shared/shared.module';

import { AdminLayoutComponent } from './admin-layout/admin-layout.component';
import { AuthLayoutComponent } from './auth-layout/auth-layout.component';
import { TopmenuComponent } from './topmenu/topmenu.component';
import { TopmenuPanelComponent } from './topmenu/topmenu-panel.component';
import { HeaderComponent } from './header/header.component';
import { BrandingComponent } from './widgets/branding.component';
import { GithubButtonComponent } from './widgets/github.component';
import { UserComponent } from './widgets/user.component';

@NgModule({
    declarations: [
        AdminLayoutComponent,
        AuthLayoutComponent,
        TopmenuComponent,
        TopmenuPanelComponent,
        HeaderComponent,
        BrandingComponent,
        GithubButtonComponent,
        UserComponent,
    ],
    imports: [SharedModule],
    exports: [
        HeaderComponent
    ]
})
export class ThemeModule {}
