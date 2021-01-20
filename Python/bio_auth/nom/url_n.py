
from django.conf.urls import url
from nom import views


urlpatterns = [
    url('^$', views.nom, name="nom"),

    url(r'^accept1/(?P<idd>\w+)', views.accept1, name='accept1'),
    url(r'^reject1/(?P<idd>\w+)', views.reject1, name='reject1'),


]