/******************************************************************************
 *			   FILE: 	circle.c
 *		           AUTHOR: 	ANAS RCHID
 *
 *           DESCRIPTION:	the approach of drawing a circle.. 
 *	     DEPENDENCY FLAGS:	`sdl2-config --cflags --libs`	
 *
 * CREATION:	11/15/2017
 * MODIFIED:	11/16/2017 
 ******************************************************************************/

#include <stdio.h>
#include <stdlib.h>

#include <math.h>

#include <SDL2/SDL.h>


#define WIDTH		(640)	/* the window width */
#define HEIGHT		(480)	/* the window height */

#define OX		(WIDTH / 2)	/* X coordinate of the center  */
#define OY		(HEIGHT / 2)	/* Y coordinate of the center  */

#define STEP		(0.0001)	/* incrementation step while 
					 * filling the plot pxels */

/* colors  */
#define BLACK		(0xFFFFFF)
#define WHITE		(0x000000)

/* boolean type */
typedef enum { false = (1 == 0), true = !false } bool;

/* the circle plot function  */
Uint32 *plot(short width, short height, double center_x, double center_y,
	     double radious);

Uint32 *plot(short w, short h, double cx, double cy, double r) {
  Uint32 *pixels = malloc(w * h * sizeof(Uint32));

  memset(pixels, BLACK, w * h * sizeof(Uint32));

  /***********************************************************************
   *	       circle equation: (x-cx)^2 + (y-cy)^2 = r^2
   ***********************************************************************
   * the upper equation gives us away to figure out the pixels places, 
   * by looping- through `x` { starting at `cx - r` (the very least point
   * to the left), to `cx + r` the very least point to the right } and 
   * each time, we solve the equation to figure out the `y`, now we have
   * a point (x, y), and we know that fo every point on one side of teh
   * circle, there's another point on the other side.
   * 
   * CONCLUTION:  
   *
   *	1. figure out x, y 
   *    2. plot (x, + y) the up point, 
   *    3. plot (x - y) the low point
   *
   ***********************************************************************/
  for (double x = (cx - r); x <= (cx + r); x += STEP) {
    double y = sqrt(abs(pow(r, 2) - pow(x - cx, 2)));
    int point[][2] = {
      {rintf(cx), rintf(cy)},
      {rintf(x), rintf(y)}
    };

    /* pixel at (x, cy + y) */
    pixels[(point[0][1] + point[1][1]) * w + point[1][0]] = WHITE;
    /* pixel at (x, cy - y) */
    pixels[(point[0][1] - point[1][1]) * w + point[1][0]] = WHITE;
  }

  return pixels;
}

int main(int argc, char **argv) {
  /* listen user events */
  SDL_Event event;

  /* initialize the SDL evirement */
  SDL_Init(SDL_INIT_VIDEO);

  /* create/allocate sdl window */
  SDL_Window *window = SDL_CreateWindow("SDL2",
					SDL_WINDOWPOS_UNDEFINED,
					SDL_WINDOWPOS_UNDEFINED, WIDTH, HEIGHT,
					0);

  /* create the renderer of the screen */
  SDL_Renderer *renderer = SDL_CreateRenderer(window, -1, 0);

  /* create the texture */
  SDL_Texture *texture = SDL_CreateTexture(renderer,
					   SDL_PIXELFORMAT_ARGB8888,
					   SDL_TEXTUREACCESS_STATIC, WIDTH,
					   HEIGHT);
  /* create pixels to put on the screen */
  Uint32 *pixels = malloc((WIDTH * HEIGHT * sizeof(Uint32)));;

  /* initialize the pixels  */
  memset(pixels, 154, WIDTH * HEIGHT * sizeof(Uint32));

  /* put the plot on the window */
  do {
    /* generate the plot as form of pixels */
    pixels = plot(WIDTH, HEIGHT, OX, OY, 200);
    /* update the window texture */
    SDL_UpdateTexture(texture, NULL, pixels, WIDTH * sizeof(Uint32));
    /* render the window */
    SDL_RenderClear(renderer);
    SDL_RenderCopy(renderer, texture, NULL, NULL);
    SDL_RenderPresent(renderer);
    /* wait for events */
    SDL_WaitEvent(&event);
  } while (!(event.type == SDL_QUIT));	/* we only care for quit event */

  /* free the plot pixles */
  free(pixels);

  /* SDL cleanup protocols */
  SDL_DestroyTexture(texture);
  SDL_DestroyRenderer(renderer);

  SDL_DestroyWindow(window);

  SDL_Quit();
  /* SDL cleanup protocols */

  return 0;
}
