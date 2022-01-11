import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { InjectableRxStompConfig, RxStompService, rxStompServiceFactory } from '@stomp/ng2-stompjs';

import { AppComponent } from './app.component';
import { gameRxStompConfig } from './rx-stomp.config';
import { GameComponent } from './game/game.component';

@NgModule({
  declarations: [
    AppComponent,
    GameComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [
    {
      provide: InjectableRxStompConfig,
      useValue: gameRxStompConfig,
    },
    {
      provide: RxStompService,
      useFactory: rxStompServiceFactory,
      deps: [InjectableRxStompConfig],
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
