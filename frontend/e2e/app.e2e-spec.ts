import { SqueezeUrlFrontEndPage } from './app.po';

describe('squeeze-url-front-end App', function() {
  let page: SqueezeUrlFrontEndPage;

  beforeEach(() => {
    page = new SqueezeUrlFrontEndPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
