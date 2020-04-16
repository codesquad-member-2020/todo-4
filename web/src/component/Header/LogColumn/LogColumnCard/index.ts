import { div, img, span } from "wonnie-template";
import {
  InlineList,
  InlineListClass,
} from "../../../../styled-component/InlineList";

import * as imgSrc from "./yein.jpg";

import "./LogColumnCard.scss";

export class LogColumnCard {
  constructor() {}
  render() {
    const imgElement = div()([
      img({ src: imgSrc, class: "log-column-card-img" })(),
    ]);

    const idTag = span({ class: "log-column-text log-column-id" })([
      "@nigayo ",
    ]);
    const contentTag = span({ class: "log-column-text" })(["moved "]);
    const footerTag = span({ class: "log-column-text" })([
      "github 공부하기asdfasdfasdfasdfasdfasdfasdfasdf",
    ]);

    const tags = div({ class: "log-column-tags" })([
      idTag,
      contentTag,
      footerTag,
    ]);

    const title = div({ class: "log-column-card-title" })([tags]);
    const footer = span({ class: "log-column-card-time" })(["38 minutes ago"]);

    const contents = InlineList({
      className: InlineListClass.SPACE_AROUND_COLUMN,
      userClassList: ["log-column-card-contents"],
      height: "100%",
    })([title, footer]);

    return InlineList({
      className: InlineListClass.DEFAULT_NO_WRAP,
      userClassList: ["log-column-card"],
      height: "4.5rem",
      width: "100%",
    })([imgElement, contents]);
  }
}