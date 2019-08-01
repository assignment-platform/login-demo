import Vue from 'vue';
import Router from 'vue-router';

import Login from './Login';
import About from './About';

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    { path: '/login', component: Login },
    { path: '/about', component: About },
    { path: '/', redirect: '/login' }
  ]
});
