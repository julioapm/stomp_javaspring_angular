import { Component, OnDestroy, OnInit } from '@angular/core';
import { RxStompService } from '@stomp/ng2-stompjs';
import { Message } from '@stomp/stompjs';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit, OnDestroy {
  public receivedMessages: string[] = [];
  private topicSubscription: Subscription = Subscription.EMPTY;

  constructor(private rxStompService: RxStompService) { }

  ngOnInit(): void {
    this.topicSubscription = this.rxStompService
      .watch('/game-play/game-update')
      .subscribe((msg: Message) => {
        this.receivedMessages.push(msg.body);
      });
  }

  ngOnDestroy(): void {
    this.topicSubscription.unsubscribe();
  }

  onPlayCard() {
    const message = {
      player: 'Player Number 1'
    };
    this.rxStompService.publish({
      destination: '/game-app/play-card',
      body: JSON.stringify(message)
    });
  }
}
