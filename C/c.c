/******************************************************************************
 *			   FILE: 	sdlgui.c       	       	       	      *
 *		           AUTHOR: 	ANAS RCHID			      *
 *									      *
 *           DESCRIPTION:	the approach of drawing a circle.. 	      *
 *	     DEPENDENCY FLAGS:	`sdl2-config --cflags --libs` -lm	      *
 *									      *
 * CREATION:	11/15/2017						      *
 * MODIFIED:	11/16/2017 						      *
 ******************************************************************************/

#include <stdio.h>
#include <stdlib.h>

#include <math.h>

#include <SDL2/SDL.h>

#define WIDTH		(640)	/* the window width */
#define HEIGHT		(480)	/* the window height */
#define CENTER(axis)	(axis/2)

/* circle's stuff */
#define OX		CENTER(WIDTH)	/* X coordinate of the center  */
#define OY		CENTER(HEIGHT)	/* Y coordinate of the center  */
#define R		(200)	/* in pixels */

#define STEP		(0.0001)	/* incrementation step while
					 * filling the plot pxels */
/* colors  */
#define BLACK		(0xFFFFFF)
#define WHITE		(0x000000)

#define TITLE		("SDL2 - WINDOW")

#define COMPARE(s1, s2)	(!strcmp(s1, s2))

#define SDL_NO_FLAGS	(0)

/* boolean type */
typedef enum { false = (1 == 0), true = !false } bool;

Uint32 *plot(short w, short h, double cx, double cy, double r) {
  Uint32 *pixels = malloc(w * h * sizeof(Uint32));

  memset(pixels, BLACK, w * h * sizeof(Uint32));

  /************************************************************************
   *	       circle equation: (x-cx)^2 + (y-cy)^2 = r^2	       	  *
   ************************************************************************
   * the upper equation gives us away to figure out the pixels places,	  *
   * by looping- through `x` { starting at `cx - r` (the very least point *
   * to the left), to `cx + r` the very least point to the right } and	  *
   * each time, we solve the equation to figure out the `y`, now we have  *
   * a point (x, y), and we know that fo every point on one side of teh	  *
   * circle, there's another point on the other side.			  *
   *									  *
   * CONCLUTION:							  *
   *									  *
   *	1. figure out x, y						  *
   *    2. plot (x, + y) the up point,					  *
   *    3. plot (x - y) the low point					  *
   *									  *
   ************************************************************************/
  for (double x = (cx - r); x <= (cx + r); x += STEP) {
    double y = sqrt(abs(pow(r, 2) - pow(x - cx, 2)));
    int point[][2] = {
      {rintf(cx), rintf(cy)},
      {rintf(x), rintf(y)}
    };

    /* pixel at (x, y + cy) */
    pixels[(point[0][1] + point[1][1]) * w + point[1][0]] = WHITE;
    /* pixel at (x, -y + cy) */
    pixels[(point[0][1] - point[1][1]) * w + point[1][0]] = WHITE;
  }

  return pixels;
}

void renderscreen(int argc, char **argv) {
  /* initialize the SDL environment */
  SDL_Init(SDL_INIT_VIDEO);

  SDL_Window *window;		/* sdl window */
  SDL_Renderer *renderer;	/* window rendrer */
  SDL_Texture *texture;		/* window texture */

  SDL_Event event;		/* listen user events */

  int _width = WIDTH, _height = HEIGHT;	/* window width and height */
  int _ox = OX, _oy = OY;
  Uint32 *pixels;		/* pixels to put on the screen */

  /* TODO: use getopt library
   *
   * for (int i = 0; i < argc; ++i) {
   *   char *nextarg = argv[i + 1], *currentarg = argv[i];
   *   bool wflag = false, hflag = false;
   *
   *   if (!wflag || COMPARE(currentarg, "-w")) {
   *     _width = atoi(nextarg);
   *     _ox = CENTER(_width);
   *     continue;
   *   } else if (!hflag || COMPARE(currentarg, "-h")) {
   *     _height = atoi(nextarg);
   *     _oy = CENTER(_height);
   *     continue;
   *   }
   *
   *   if (wflag && hflag) {
   *     break;
   *   }
   * }
   */

  char *_title = TITLE;

  /* φιλοσοφία */
  /* 1.1. create/allocate sdl window */
  window = SDL_CreateWindow(_title,
			    SDL_WINDOWPOS_UNDEFINED,
			    SDL_WINDOWPOS_UNDEFINED, _width, _height,
			    SDL_NO_FLAGS);

  /* 1.2. create the renderer of the screen */
  renderer = SDL_CreateRenderer(window, -1, SDL_NO_FLAGS);

  /* 1.3. create the texture */
  texture = SDL_CreateTexture(renderer,
			      SDL_PIXELFORMAT_ARGB8888,
			      SDL_TEXTUREACCESS_STATIC, _width, _height);

  /* 2. generate the plot as form of pixels */
  pixels = plot(_width, _height, _ox, _oy, R);

  /* 3 screen loop */
  do {
    /* 3.1. update the window texture */
    SDL_UpdateTexture(texture, NULL, pixels, WIDTH * sizeof(Uint32));
    /* 3.2. render the window */
    SDL_RenderClear(renderer);
    SDL_RenderCopy(renderer, texture, NULL, NULL);
    SDL_RenderPresent(renderer);
    /* 3.3. wait for events */
    SDL_WaitEvent(&event);
  } while (!(event.type == SDL_QUIT));	/* we only care for quit event */

  /* 4.1. free the plot pixles */
  free(pixels);

  /* 4.2. SDL cleanup */
  SDL_DestroyTexture(texture);
  SDL_DestroyRenderer(renderer);
  SDL_DestroyWindow(window);

  /* 4.3 close SDL environment */
  SDL_Quit();
}

int main() {
  renderscreen(0, NULL);
}
