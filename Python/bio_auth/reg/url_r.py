
from django.conf.urls import url
from reg import views

urlpatterns = [
    url('^$', views.reg, name="reg"),
    url(r'^accept2/(?P<idd>\w+)', views.accept2, name='accept2'),
    url(r'^reject2/(?P<idd>\w+)', views.reject2, name='reject2'),
]

