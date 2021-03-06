import { configure } from "@storybook/html";
import interopRequireDefault from "@babel/runtime/helpers/interopRequireDefault";

import "../src/util/style/semantic-ui/icon.css";
import "../src/util/style/reset.scss";

function loadStories() {
  const context = require.context("../src/stories", true, /Story\.jsx$/);

  context.keys().forEach((srcFile) => {
    interopRequireDefault(context(srcFile));
  });
}

configure(loadStories, module);
