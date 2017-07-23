// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package br.com.frcnetto.chatapp.activity;

import br.com.frcnetto.chatapp.service.ChatService;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<ChatService> serviceProvider;

  public MainActivity_MembersInjector(Provider<ChatService> serviceProvider) {
    assert serviceProvider != null;
    this.serviceProvider = serviceProvider;
  }

  public static MembersInjector<MainActivity> create(Provider<ChatService> serviceProvider) {
    return new MainActivity_MembersInjector(serviceProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.service = serviceProvider.get();
  }

  public static void injectService(MainActivity instance, Provider<ChatService> serviceProvider) {
    instance.service = serviceProvider.get();
  }
}
