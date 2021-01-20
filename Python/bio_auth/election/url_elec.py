from django.conf.urls import url
from election import views


urlpatterns = [
    url('^$', views.election, name="election"),
    ]