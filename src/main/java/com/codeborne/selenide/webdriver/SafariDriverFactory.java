package com.codeborne.selenide.webdriver;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Config;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class SafariDriverFactory extends AbstractDriverFactory {
  private static final Logger log = LoggerFactory.getLogger(SafariDriverFactory.class);

  @Override
  boolean supports(Config config, Browser browser) {
    return browser.isSafari();
  }

  @Override
  WebDriver create(Config config, Proxy proxy) {
    return createSafariDriver(config, proxy);
  }

  private WebDriver createSafariDriver(Config config, Proxy proxy) {
    if (!config.browserBinary().isEmpty()) {
      log.info("Using browser binary: {}", config.browserBinary());
      log.warn("Changing browser binary not supported in Safari, setting will be ignored.");
    }
    return createInstanceOf("org.openqa.selenium.safari.SafariDriver", config, proxy);
  }
}
