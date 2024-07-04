import { Route } from '@angular/router';
import { initialDataResolver } from 'app/app.resolvers';
import { LayoutComponent } from 'app/layout/layout.component';
import { AuthGuard } from './providers/guards/auth.guard';
import { NoAuthGuard } from './providers/guards/noAuth.guard';

export const appRoutes: Route[] = [
    { path: '', pathMatch: 'full', redirectTo: 'example' },
    { path: 'signed-in-redirect', pathMatch: 'full', redirectTo: 'example' },

    {
        path: '',
        canActivate: [NoAuthGuard],
        canActivateChild: [NoAuthGuard],
        component: LayoutComponent,
        data: { layout: 'empty' },
        children: [
            {
                path: 'confirmation-required',
                loadChildren: () =>
                    import('app/modules/auth/confirmation-required/confirmation-required.routes'),
            },
            {
                path: 'forgot-password',
                loadChildren: () =>
                    import('app/modules/auth/forgot-password/forgot-password.routes'),
            },
            {
                path: 'reset-password',
                loadChildren: () =>
                    import('app/modules/auth/reset-password/reset-password.routes'),
            },
            {
                path: 'sign-in',
                loadChildren: () =>
                    import('app/modules/auth/sign-in/sign-in.routes'),
            },
            {
                path: 'sign-up',
                loadChildren: () =>
                    import('app/modules/auth/sign-up/sign-up.routes'),
            },
        ],
    },
    {
        path: '',
        canActivate: [AuthGuard],
        canActivateChild: [AuthGuard],
        component: LayoutComponent,
        data: { layout: 'empty' },
        children: [
            {
                path: 'sign-out',
                loadChildren: () =>
                    import('app/modules/auth/sign-out/sign-out.routes'),
            },
            {
                path: 'unlock-session',
                loadChildren: () =>
                    import('app/modules/auth/unlock-session/unlock-session.routes'),
            },
        ],
    },
    {
        path: '',
        component: LayoutComponent,
        data: { layout: 'empty' },
        children: [
            {
                path: 'home',
                loadChildren: () =>
                    import('app/modules/landing/home/home.routes'),
            },
        ],
    },
    {
        path: '',
        canActivate: [AuthGuard],
        canActivateChild: [AuthGuard],
        component: LayoutComponent,
        resolve: { initialData: initialDataResolver },
        children: [
            { path: 'example', loadChildren: () => import('app/modules/admin/example/example.routes') },
            { path: 'tree', loadChildren: () => import('app/modules/admin/crud-tree/crud-tree.routes') },
            { path: 'homeScreen', loadChildren: () => import('app/views/views.routes') },
            { path: 'homeScreen/setup/instructor', loadChildren: () => import('app/views/dashboard/setup/instructor/instructor.routers').then(m => m.default) },
            { path: 'homeScreen/setup/clase', loadChildren: () => import('app/views/dashboard/setup/clase/clase.routers').then(m => m.default) } // Nueva ruta
        ]
    },
];
