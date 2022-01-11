import { InjectableRxStompConfig } from '@stomp/ng2-stompjs';
import * as SockJS from 'sockjs-client';

export const gameRxStompConfig: InjectableRxStompConfig = {
  //endereço do servidor
  brokerURL: 'ws://localhost:8080/game-websocket',
  webSocketFactory: () => new SockJS('http://localhost:8080/game-websocket'),
  //debug, não usar em produção
  debug: (msg) => {
    console.log(new Date(), msg);
  }
};
