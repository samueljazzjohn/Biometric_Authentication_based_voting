from django.conf.urls import url
from withdraw import views

urlpatterns = [
    url('^$', views.withdraw, name="withdraw"),
    url(r'^accept/(?P<idd>\w+)', views.accept, name='accept'),
    url(r'^reject/(?P<idd>\w+)', views.reject, name='reject'),



]