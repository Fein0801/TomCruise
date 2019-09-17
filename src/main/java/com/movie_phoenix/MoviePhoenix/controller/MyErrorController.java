package com.movie_phoenix.MoviePhoenix.controller;

import org.springframework.boot.web.servlet.error.ErrorController;

public class MyErrorController implements ErrorController {

	@Override
	public String getErrorPath() {
		return "error";
	}
}
