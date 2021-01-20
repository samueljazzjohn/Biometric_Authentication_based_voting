from django.conf.urls import url
from add_law import views


urlpatterns = [
    url('^$', views.law, name="law"),
    ]