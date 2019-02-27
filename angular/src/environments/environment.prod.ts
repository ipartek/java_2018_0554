// ng build --env=prod
// ng build --prod --env=prod
// --prod option will minify all files and do all other sorts of cool things which are not so important right now. It is good to mention that one of my builds went from 7MB to 2.3MB when I used this option.

export const environment = {
  production: true,
  texto: 'PRODUCCION'
};
