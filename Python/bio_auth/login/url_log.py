from django.conf.urls import url
from login import views


urlpatterns = [
    url('^$', views.login, name="Login"),
    url('^logout/', views.login, name="Login"),
    ]